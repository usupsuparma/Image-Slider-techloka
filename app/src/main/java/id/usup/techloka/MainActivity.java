package id.usup.techloka;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
	private FrameLayout mFrameLayout;
	private HomeFragment mHomeFragment;
	
	private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
			= new BottomNavigationView.OnNavigationItemSelectedListener() {
		
		@Override
		public boolean onNavigationItemSelected(@NonNull MenuItem item) {
			switch (item.getItemId()) {
				case R.id.navigation_home:
					getHomeFragement();
					return true;
				case R.id.navigation_dashboard:
					DashBoardFragment dashBoardFragment = new DashBoardFragment();
					FragmentTransaction ftDashboard = getSupportFragmentManager().beginTransaction();
					ftDashboard.replace(R.id.fm_content, dashBoardFragment);
					ftDashboard.commit();
					return true;
				case R.id.navigation_notifications:
					NotificationFragment notificationFragment = new NotificationFragment();
					FragmentTransaction ftNotification = getSupportFragmentManager().beginTransaction();
					ftNotification.replace(R.id.fm_content, notificationFragment);
					ftNotification.commit();
					return true;
			}
			return false;
		}
	};
	
	private void getHomeFragement() {
		if (mHomeFragment ==null) {
			mHomeFragment = HomeFragment.newInstance();
		}
		
		buildFragment(mHomeFragment);
		
	}
	
	private void buildFragment(Fragment fragment) {
		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.fm_content, fragment)
				.commit();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		BottomNavigationView navView = findViewById(R.id.nav_view);
		mFrameLayout = findViewById(R.id.fm_content);
		HomeFragment homeFragment = HomeFragment.newInstance();
		FragmentTransaction ftHome = getSupportFragmentManager().beginTransaction();
		ftHome.replace(R.id.fm_content, homeFragment);
		ftHome.commit();
		
		navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
	}
	
}
