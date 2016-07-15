package com.liuyfly.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.junit.Test;

public class TestHttpClient {

    private final static int READ_BODY_SIZE = 5120;

    @Test
    public void test() {
        String url = "http://10.253.100.44:5083/com.zhongan.core.comperloan.service.PersonApplyLoanCheckService:1.0.0/getCities";
        JSONObject json = new JSONObject();
        json.put("code", "110000");
        String jsonString = "[" + json.toString() + "]";

        try {
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(url);
            post.addRequestHeader("Content-Type", "application/json");
            post.setRequestHeader("Connection", "close");
            byte[] bytes = jsonString.getBytes("UTF-8");
            RequestEntity params = new ByteArrayRequestEntity(bytes);
            post.setRequestEntity(params);
            client.executeMethod(post);
            String result = streamReadHtml(post.getResponseBodyAsStream());
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String streamReadHtml(InputStream istream) throws UnsupportedEncodingException {
        String html = "";
        byte[] responseBody = new byte[READ_BODY_SIZE];
        int npos = 0;
        int nread = 0;
        try {
            while ((nread = istream.read(responseBody, npos, responseBody.length - npos)) >= 0) {
                npos += nread;
                byte[] tmpBuf = new byte[npos + READ_BODY_SIZE];
                System.arraycopy(responseBody, 0, tmpBuf, 0, npos);
                responseBody = tmpBuf;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != istream) {
                    istream.close();
                }
                istream = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        html = new String(responseBody, 0, npos, "UTF-8");
        return html;
    }
}
