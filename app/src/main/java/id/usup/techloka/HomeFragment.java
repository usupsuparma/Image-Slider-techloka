package id.usup.techloka;

import android.annotation.SuppressLint;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import id.usup.techloka._sliders.FragmentSlider;
import id.usup.techloka._sliders.SliderIndicator;
import id.usup.techloka._sliders.SliderPagerAdapter;
import id.usup.techloka._sliders.SliderView;

public class HomeFragment extends Fragment {
	
	private HomeViewModel mViewModel;
	private SliderPagerAdapter mAdapter;
	private SliderIndicator mIndicator;
	
	private SliderView sliderView;
	
	private LinearLayout mLinearLayout;
	
	@SuppressLint("ValidFragment")
	private HomeFragment() {
	}
	
	public static HomeFragment newInstance() {
		return new HomeFragment();
	}
	
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
	                         @Nullable Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.home_fragment, container, false);
		sliderView = rootView.findViewById(R.id.sliderView);
		mLinearLayout = rootView.findViewById(R.id.pagesContainer);
		setupSlider();
		return rootView;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
		// TODO: Use the ViewModel
		
	}
	
	private void setupSlider() {
		sliderView.setDurationScroll(2000);
		List<Fragment> fragments = new ArrayList<>();
		fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
		fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
		fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
		fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));
//        fragments.add(FragmentSlider.newInstance("https://www.sepakbola.com/wp-content/uploads/2019/05/ronaldo-messi-barcelona-juventus-1.jpg"));
//        fragments.add(FragmentSlider.newInstance("https://scontent-sin6-2.xx.fbcdn.net/v/t1.0-9/45797985_1915166681899661_1225679405947289600_o.jpg?_nc_cat=102&_nc_ht=scontent-sin6-2.xx&oh=13bca031842d563853701d610e8124ba&oe=5D54FAE3"));
//        fragments.add(FragmentSlider.newInstance("https://scontent-sin6-2.xx.fbcdn.net/v/t1.0-9/35366230_1847607001944877_4831795915457036288_o.jpg?_nc_cat=107&_nc_ht=scontent-sin6-2.xx&oh=51005e2eb212762314e4c0e329b84663&oe=5D685D4A"));
//
		mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
		sliderView.setAdapter(mAdapter);
		mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
		mIndicator.setPageCount(fragments.size());
		mIndicator.show();
	}
	
}
