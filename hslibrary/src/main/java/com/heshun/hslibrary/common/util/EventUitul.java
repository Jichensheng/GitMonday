package com.heshun.hslibrary.common.util;

/**
 * author：Jics
 * 2016/8/1 14:57
 */
public class EventUitul {
	private int type;
	public EventUitul(int type){
		this.type=type;
	}

	public int getType() {
		return type;
	}
}
/*
* =======维护列表(type:详情)=======
* 1:极光推送接收到消息（PushMessageReceiver），用户中心出现小红点(UserCenterFragment)，消息界面会刷新数据(MailActivity)
* 2：用户修改完资料(UserInfoActivity)，用户中心异步更新用户信息(UserCenterFragment)
* 3：消息界面删除按钮的控制（显示）(SlideAdapter、MailActivity)
* 4：消息界面删除按钮的控制（闭合）(SlideAdapter、MailActivity)
* 5: 切换到第二页时地图视图回到初始状况（MainActivity、ChargeStationMapFragment）
* 6: 用户评论返回评论列表（OrderCommentActivity、CommentListFragment）
* 7: 用户引导触发事件
* 8: 头像引导事件
* */