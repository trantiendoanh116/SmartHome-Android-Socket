package com.iot.smarthome.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.iot.smarthome.R;
import com.iot.smarthome.adapters.MyAdapter;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        } else {
            setContentView(R.layout.activity_main);
            TabLayout tabLayout = findViewById(R.id.tabLayout);
            viewPager = findViewById(R.id.viewPager);

            tabLayout.addTab(tabLayout.newTab().setText("Thiết bị"));
            tabLayout.addTab(tabLayout.newTab().setText("Cảm biến"));
            tabLayout.addTab(tabLayout.newTab().setText("Tự động hóa"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

            final MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(adapter);

            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
    }
/*
    private void processData(Map<String, Object> data) {
        PrefManager prefManager = new PrefManager(this);
        try {
            //Den Tran KH1
            if (data.containsKey(AppConfig.DEN_TRAN_KH1_ID)) {
                try {
                    prefManager.putLong(PrefManager.DEN_TRAN_KH1, (int) (long) data.get(AppConfig.DEN_TRAN_KH1_ID));
                } catch (Exception e) {
                    Log.e(TAG, "Den KH1: " + e.getMessage());
                    prefManager.putLong(PrefManager.DEN_TRAN_KH1, -1);
                }
            }
            //Den Chum KH1
            if (data.containsKey(AppConfig.den_chum_kh1)) {
                try {
                    prefManager.putInt(PrefManager.DEN_CHUM_KH1, (int) (long) data.get(AppConfig.den_chum_kh1));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_CHUM_KH1, -1);
                }
            }
            //Den Tranh KH1
            if (data.containsKey(AppConfig.den_tranh_kh1)) {
                try {
                    prefManager.putInt(PrefManager.DEN_TRANH_KH1, (int) (long) data.get(AppConfig.den_tranh_kh1));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_TRANH_KH1, -1);
                }
            }
            //Quat Tran
            if (data.containsKey(AppConfig.quat_tran)) {
                try {
                    prefManager.putInt(PrefManager.QUAT_TRAN, (int) (long) data.get(AppConfig.quat_tran));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.QUAT_TRAN, -1);
                }
            }
            //Den Tranh tri KH1
            if (data.containsKey(AppConfig.den_trangtri_kh1)) {
                try {
                    prefManager.putInt(PrefManager.DEN_TRANGTRI_KH1, (int) (long) data.get(AppConfig.den_trangtri_kh1));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_TRANGTRI_KH1, -1);
                }
            }
            //Den Tran KH2
            if (data.containsKey(AppConfig.den_tran_kh2)) {
                try {
                    prefManager.putInt(PrefManager.DEN_TRAN_KH2, (int) (long) data.get(AppConfig.den_tran_kh2));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_TRAN_KH2, -1);
                }
            }
            //Den Chum KH2
            if (data.containsKey(AppConfig.den_chum_kh2)) {
                try {
                    prefManager.putInt(PrefManager.DEN_CHUM_KH2, (int) (long) data.get(AppConfig.den_chum_kh2));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_CHUM_KH2, -1);
                }
            }
            //Den Tranh KH2
            if (data.containsKey(AppConfig.den_tranh_kh2)) {
                try {
                    prefManager.putInt(PrefManager.DEN_TRANH_KH2, (int) (long) data.get(AppConfig.den_tranh_kh2));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_TRANH_KH2, -1);
                }
            }
            //Den San
            if (data.containsKey(AppConfig.den_san)) {
                try {
                    prefManager.putInt(PrefManager.DEN_SAN, (int) (long) data.get(AppConfig.den_san));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_SAN, -1);
                }
            }
            //Den Cong
            if (data.containsKey(AppConfig.den_cong)) {
                try {
                    prefManager.putInt(PrefManager.DEN_CONG, (int) (long) data.get(AppConfig.den_cong));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_CONG, -1);
                }
            }
            //Den WC
            if (data.containsKey(AppConfig.den_wc)) {
                try {
                    prefManager.putInt(PrefManager.DEN_WC, (int) (long) data.get(AppConfig.den_wc));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_WC, -1);
                }
            }
            //Binh NL
            if (data.containsKey(AppConfig.binh_nl)) {
                try {
                    prefManager.putInt(PrefManager.BINH_NL, (int) (long) data.get(AppConfig.binh_nl));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.BINH_NL, -1);
                }
            }
            //Den Cua Ngach
            if (data.containsKey(AppConfig.den_cua_ngach)) {
                try {
                    prefManager.putInt(PrefManager.DEN_CUA_NGACH, (int) (long) data.get(AppConfig.den_cua_ngach));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_CUA_NGACH, -1);
                }
            }
            //Den 1 bep
            if (data.containsKey(AppConfig.den_bep_1)) {
                try {
                    prefManager.putInt(PrefManager.DEN_BEP_1, (int) (long) data.get(AppConfig.den_bep_1));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_BEP_1, -1);
                }
            }
            //Den 2 bep
            if (data.containsKey(AppConfig.den_bep_2)) {
                try {
                    prefManager.putInt(PrefManager.DEN_BEP_2, (int) (long) data.get(AppConfig.den_bep_2));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.DEN_BEP_2, -1);
                }
            }
            //Khi Loc
            if (data.containsKey(AppConfig.khi_loc)) {
                try {
                    prefManager.putInt(PrefManager.KHI_LOC, (int) (long) data.get(AppConfig.khi_loc));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.KHI_LOC, -1);
                }
            }
            //AT Bep
            if (data.containsKey(AppConfig.at_bep)) {
                try {
                    prefManager.putInt(PrefManager.AT_BEP, (int) (long) data.get(AppConfig.at_bep));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.AT_BEP, -1);
                }
            }
            //AT Tong
            if (data.containsKey(AppConfig.at_tong)) {
                try {
                    prefManager.putInt(PrefManager.AT_TONG, (int) (long) data.get(AppConfig.at_tong));
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    prefManager.putInt(PrefManager.AT_TONG, -1);
                }
            }
            if (data.containsKey(AppConfig.temp_humi)) {
                try {
                    HashMap<String, Double> hashMap = (HashMap<String, Double>) data.get(AppConfig.temp_humi);
                    double temp = new Double(hashMap.get(AppConfig.KEY_TEMP).toString());
                    double humi = new Double(hashMap.get(AppConfig.KEY_HUMI).toString());
                    prefManager.putDouble(PrefManager.TEMP, temp);
                    prefManager.putDouble(PrefManager.HUMI, humi);
                } catch (Exception e) {
                    Log.e(TAG, "Nhiet do vaf do am: " + e.getMessage());
                    prefManager.putDouble(PrefManager.TEMP, -1);
                    prefManager.putDouble(PrefManager.HUMI, -1);
                }
            }
            //Khi CO bep
            if (data.containsKey(AppConfig.co)) {
                try {
                    prefManager.putDouble(PrefManager.KHOI_CO, new Double(data.get(AppConfig.co).toString()));
                } catch (Exception e) {
                    Log.e(TAG, "Co: " + e.getMessage());
                    prefManager.putDouble(PrefManager.KHOI_CO, -1);
                }
            }
            //Nong do bui min
            if (data.containsKey(AppConfig.dust)) {
                try {
                    prefManager.putDouble(PrefManager.DUST, new Double(data.get(AppConfig.dust).toString()));
                } catch (Exception e) {
                    Log.e(TAG, "Bui: " + e.getMessage());
                    prefManager.putDouble(PrefManager.DUST, -1);
                }
            }
            //Dong Dien Tong
            if (data.containsKey(AppConfig.do_dien_tong)) {
                try {
                    HashMap<String, Object> hashMap = (HashMap<String, Object>) data.get(AppConfig.do_dien_tong);
                    double amp = new Double(hashMap.get(AppConfig.KEY_AMPE).toString());
                    double vol = new Double(hashMap.get(AppConfig.KEY_VOLTAGE).toString());
                    double energy = new Double(hashMap.get(AppConfig.KEY_ENERGY).toString());
                    prefManager.putDouble(PrefManager.DONGDIEN_AMPE, amp);
                    prefManager.putDouble(PrefManager.DONGDIEN_VOL, vol);
                    prefManager.putDouble(PrefManager.CONG_SUAT_TIEU_THU, energy);
                } catch (Exception e) {
                    Log.e(TAG, "Dien: " + e.getMessage());
                    prefManager.putDouble(PrefManager.DONGDIEN_AMPE, -1);
                    prefManager.putDouble(PrefManager.DONGDIEN_VOL, -1);
                    prefManager.putDouble(PrefManager.CONG_SUAT_TIEU_THU, -1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

 */
}
