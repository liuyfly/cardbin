!function($) {

	var alert_id = '_bootstrap_dialog_alert', confirm_id = '_bootstrap_dialog_confirm', confirm_yes_btn_id = '_bootstrap_dialog_confirm_yes_btn', confirm_cancel_btn_id = '_bootstrap_dialog_confirm_cancel_btn';

	$(function() {

		var html = [
				'<div id="',
				alert_id,
				'" class="modal hide fade"><div class="modal-header"><button type="button" class="close" data-dismiss="modal"	aria-hidden="true">&times;</button><h3>系统信息</h3></div><div class="modal-body"><p></p></div><div class="modal-footer">	<a href="#" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">确定</a></div></div><div id="',
				confirm_id,
				'" class="modal hide fade"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h3>系统提示</h3></div><div class="modal-body"><p></p></div><div class="modal-footer"><button id="',
				confirm_yes_btn_id,
				'" class="btn btn-primary" data-dismiss="modal" aria-hidden="true">确定</button><button id="',
				confirm_cancel_btn_id,
				'" class="btn btn-primary" data-dismiss="modal"	aria-hidden="true">取消</button></div></div>' ];

		$(document.body).append(html.join(''));

	});

	window.Dialog = {

		alert : function(message, callback, title) {
			var dialog = $([ '#', alert_id ].join(''));
			dialog.find('.modal-body p').html(message);

			if (title) {
				dialog.find('.modal-header h3').html(message);
			}

			if (callback) {
				dialog.one('hidden', callback);
			}

			dialog.modal({
				show : true
			});

			return dialog;
		},

		confirm : function(message, callback, title) {
			var dialog = $([ '#', confirm_id ].join(''));
			dialog.find('.modal-body p').html(message);

			if (title) {
				dialog.find('.modal-header h3').html(message);
			}

			var yesBtn = dialog.find([ '#', confirm_yes_btn_id ].join(''));
			var cancelBtn = dialog
					.find([ '#', confirm_cancel_btn_id ].join(''));

			var invoker = function() {
				callback();
				yesBtn.unbind('click', invoker);
			};
			yesBtn.bind('click', invoker);

			cancelBtn.one('click', function() {
				yesBtn.unbind('click', invoker);
			});

			dialog.on('hidden', function() {
				yesBtn.unbind('click', invoker);
			});

			dialog.modal({
				show : true,
				backdrop : 'static'
			});

		}

	};

}(jQuery);
