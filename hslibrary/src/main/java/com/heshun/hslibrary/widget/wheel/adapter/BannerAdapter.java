package com.heshun.hslibrary.widget.wheel.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.heshun.hslibrary.R;
import com.heshun.hslibrary.common.config.Config;
import com.heshun.hslibrary.widget.wheel.entity.BannerItem;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 
 * 广告栏viewpager适配器
 * 
 * @author huangxz
 *
 * @param <T>
 */
public class BannerAdapter<T> extends PagerAdapter {

	private DisplayImageOptions mOptions = new DisplayImageOptions.Builder().cacheInMemory()
			.showImageForEmptyUri(R.drawable.banner_default_icon).showStubImage(R.drawable.banner_default_icon)
			.cacheOnDisc().build();

	private Context mContext;

	private List<T> mData;

	public BannerAdapter(Context c) {
		this.mContext = c;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public int getCount() {
		return null == mData ? 0 : mData.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	public void setData(List<T> data) {
		this.mData = data;
	}

	@Override
	public Object instantiateItem(ViewGroup container, final int position) {
		T item = mData.get(position);

		View view = LayoutInflater.from(mContext).inflate(R.layout.banner_item_pic, null, false);
		if (item instanceof BannerItem) {
			BannerItem banner = (BannerItem) item;
			ImageView imageView = (ImageView) view.findViewById(R.id.img_pic);
			ImageLoader.getInstance().displayImage(Config.UPLOAD.concat(banner.indexImage), imageView, mOptions);
			container.addView(view, 0);
			view.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// T data = mData.get(position);
					// String url =
					// "http://u.eqxiu.com/s/c9tXPRCl?eqrcode=1&from=singlemessage&isappinstalled=0";
					// Intent webIntent = new Intent(mContext,
					// WebViewActivity.class);
					// webIntent.putExtra("url", url);
					// mContext.startActivity(webIntent);
				}
			});
		}
		return view;
	}

}
