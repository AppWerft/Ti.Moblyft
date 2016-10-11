package ti.moblyft;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollObject;
import org.appcelerator.kroll.common.Log;

import com.moblyft.interfaces.MoblyftAdListener;
import com.moblyft.pojo.MoblyftRewardInfo;

public final class MymoblyftAdListener implements MoblyftAdListener {
	private KrollFunction onResult;
	private KrollObject krollObject;

	void setKroll(KrollFunction onResult, KrollObject krollObject) {
		this.krollObject = krollObject;
		this.onResult = onResult;
	}

	@Override
	public void adAvailable() {
		if (onResult != null) {
			KrollDict dict = new KrollDict();
			dict.put("adAvailable", true);
			onResult.call(krollObject, dict);
		}
		Log.d(MoblyftModule.LCAT, "adAvailable");
	}

	@Override
	public void adFailedWithError(String errorMessage) {
		if (onResult != null) {
			KrollDict dict = new KrollDict();
			dict.put("adAvailable", false);
			dict.put("error", errorMessage);
			onResult.call(krollObject, dict);
		}
		Log.d(MoblyftModule.LCAT, "adFailedWithError " + errorMessage);
		// This callback method will get call if ad is failed to cache
	}

	@Override
	public void adDidShow() {
		Log.d(MoblyftModule.LCAT, "adDidShow");
		if (onResult != null) {
			KrollDict dict = new KrollDict();
			dict.put("adDidShow", true);
			onResult.call(krollObject, dict);
		}
		// This callback method will get call when ad shows or get opened
	}

	@Override
	public void adDidHide() {
		if (onResult != null) {
			KrollDict dict = new KrollDict();
			dict.put("adDidHide", true);
			onResult.call(krollObject, dict);
		}
		// This callback method will get call when ad hides or get closed
	}

	@Override
	public void onRewardReceived(MoblyftRewardInfo rewardDetail) {
		// This callback method will only calls in case of Rewarded Video Ad
		// To get the reward details from 'rewardDetail' object
		String rewardName = rewardDetail.getRewardName();
		if (onResult != null) {
			KrollDict dict = new KrollDict();
			dict.put("onRewardReceived", true);
			dict.put("rewardName", rewardDetail.getRewardName() + " count="
					+ rewardDetail.getRewardCount());
			onResult.call(krollObject, dict);
		}
		Log.d(MoblyftModule.LCAT, "rewardName=" + rewardName);
	}

}
