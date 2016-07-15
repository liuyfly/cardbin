package com.liuyfly.common.tree;

import com.liuyfly.biz.dal.dataobject.CardBinDO;

public class BinaryTree {
    private Node root = new Node();

    public void insert(String panPri, CardBinDO cardbin) {
        char[] panPriChar = panPri.toCharArray();
        Node start = root;
        for (char c : panPriChar) {
            Integer offset = Integer.parseInt(c + "");
            Node node = start.children[offset];
            if (node == null) {
                node = new Node();
                node.parent = start;
                start.children[offset] = node;
            }
            start = node;
        }
        start.data = cardbin;
    }

    public CardBinDO search(String pan) {
        char[] panChar = pan.toCharArray();
        Node start = root;
        for (char c : panChar) {
            Integer offset = Integer.parseInt(c + "");
            Node node = start.children[offset];
            if (node == null) {
                return start.data;
            } else {
                start = node;
            }
        }
        if (start != null) {
            return start.data;
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            BinaryTree tree = new BinaryTree();

            CardBinDO cardbin = new CardBinDO();
            cardbin.setInstName("农业银行");
            cardbin.setCardName("金穗信用卡(银联卡)");
            cardbin.setCardType("03");
            cardbin.setPanPri("49102");
            tree.insert(cardbin.getPanPri(), cardbin);

            cardbin = new CardBinDO();
            cardbin.setInstName("农行(武汉市)");
            cardbin.setCardName("金穗信用卡(银联卡)");
            cardbin.setCardType("01");
            cardbin.setPanPri("491020005");
            tree.insert(cardbin.getPanPri(), cardbin);

            cardbin = new CardBinDO();
            cardbin.setInstName("农行广东省分行");
            cardbin.setCardName("金穗信用卡(银联卡)");
            cardbin.setCardType("01");
            cardbin.setPanPri("491020008");
            tree.insert(cardbin.getPanPri(), cardbin);

            System.out.println(tree.search("49102000895123"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    class Node {
        Node      parent;
        Node[]    children = new Node[10];
        CardBinDO data;
    }
}
