package com.creativeshare.emdad.Activites_Fragments.Activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.multidex.MultiDex;

import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_About_App;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Connecting_Water;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Contact_US;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Fifth_shipping_Transportation;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Fourth_shipping_Transpoortation;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Orders;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Profile;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_First_shipping_Transportation;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Home;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Main_Shipping_Transportation;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Rental_Of_Equipment;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Terms_Condition;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Third_shipping_Transportation;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Upgrade_To_Company;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_main;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_more;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_seconed_shipping_Transportation;
import com.creativeshare.emdad.Language.Language;
import com.creativeshare.emdad.R;

public class Home_Activity extends AppCompatActivity {
    private int fragment_count = 0;
    private FragmentManager fragmentManager;

    private Fragment_Home fragment_home;
    private Fragment_main fragment_main;
    private Fragment_Orders fragment_orders;
    private Fragment_Profile fragment_profile;
    private Fragment_Upgrade_To_Company fragment_upgrade_to_company;
    private Fragment_more fragment_more;
    private Fragment_Terms_Condition fragment_terms_condition;
    private Fragment_About_App fragment_about_app;
    private Fragment_Contact_US fragment_contact_us;
    private Fragment_Connecting_Water fragment_connecting_water;
    private Fragment_Main_Shipping_Transportation fragment_main_shipping_transportation;
    private Fragment_Rental_Of_Equipment fragment_rental_of_equipment;
    private Fragment_First_shipping_Transportation fragment_first_shipping_transportation;
    private Fragment_seconed_shipping_Transportation fragment_seconed_shipping_transportation;
    private Fragment_Third_shipping_Transportation fragment_third_shipping_transportation;
    private Fragment_Fourth_shipping_Transpoortation fragment_fourth_shipping_transpoortation;
    private Fragment_Fifth_shipping_Transportation fragment_fifth_shipping_transportation;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Language.updateResources(newBase, Language.getLanguage(newBase)));
        MultiDex.install(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = this.getSupportFragmentManager();
        setContentView(R.layout.activity_home_);
        if (savedInstanceState == null) {
            DisplayFragmentHome();
            DisplayFragmentMain();
        }

    }

    public void DisplayFragmentHome() {

        fragment_count += 1;

        if (fragment_home == null) {
            fragment_home = Fragment_Home.newInstance();
        }

        if (fragment_home.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_home).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_app_container, fragment_home, "fragment_home").addToBackStack("fragment_home").commit();
        }

    }

    public void DisplayFragmentMain() {

        if (fragment_orders != null && fragment_orders.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_orders).commit();
        }


        if (fragment_profile != null && fragment_profile.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_profile).commit();
        }
        if (fragment_more != null && fragment_more.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_more).commit();
        }

        if (fragment_main == null) {
            fragment_main = Fragment_main.newInstance();
        }

        if (fragment_main.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_main).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_main_child, fragment_main, "fragment_main").addToBackStack("fragment_main").commit();

        }
        if (fragment_home != null && fragment_home.isAdded()) {
            fragment_home.UpdateAHBottomNavigationPosition(0);
        }

    }

    public void DisplayFragmentOrders() {

        if (fragment_profile != null && fragment_profile.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_profile).commit();
        }


        if (fragment_more != null && fragment_more.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_more).commit();
        }
        if (fragment_main != null && fragment_main.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_main).commit();
        }

        if (fragment_orders == null) {
            fragment_orders = Fragment_Orders.newInstance();
        }

        if (fragment_orders.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_orders).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_main_child, fragment_orders, "fragment_orders").addToBackStack("fragment_orders").commit();

        }
        if (fragment_home != null && fragment_home.isAdded()) {
            fragment_home.UpdateAHBottomNavigationPosition(1);
        }

    }

    public void DisplayFragmentProfile() {

        if (fragment_orders != null && fragment_orders.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_orders).commit();
        }


        if (fragment_more != null && fragment_more.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_more).commit();
        }
        if (fragment_main != null && fragment_main.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_main).commit();
        }

        if (fragment_profile == null) {
            fragment_profile = Fragment_Profile.newInstance();
        }

        if (fragment_profile.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_profile).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_main_child, fragment_profile, "fragment_profile").addToBackStack("fragment_profile").commit();

        }
        if (fragment_home != null && fragment_home.isAdded()) {
            fragment_home.UpdateAHBottomNavigationPosition(2);
        }

    }

    public void DisplayFragmentMore() {

        if (fragment_orders != null && fragment_orders.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_orders).commit();
        }


        if (fragment_profile != null && fragment_profile.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_profile).commit();
        }
        if (fragment_main != null && fragment_main.isAdded()) {
            fragmentManager.beginTransaction().hide(fragment_main).commit();
        }

        if (fragment_more == null) {
            fragment_more = Fragment_more.newInstance();
        }

        if (fragment_more.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_more).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_main_child, fragment_more, "fragment_more").addToBackStack("fragment_more").commit();

        }
        if (fragment_home != null && fragment_home.isAdded()) {
            fragment_home.UpdateAHBottomNavigationPosition(3);
        }

    }

    public void DisplayFragmentTerms_Condition() {
        fragment_count += 1;

        fragment_terms_condition = Fragment_Terms_Condition.newInstance().newInstance();


        if (fragment_terms_condition.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_terms_condition).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_app_container, fragment_terms_condition, "fragment_terms_condition").addToBackStack("fragment_terms_condition").commit();

        }
    }

    public void DisplayFragmentAbout() {
        fragment_count += 1;

        fragment_about_app = Fragment_About_App.newInstance().newInstance();


        if (fragment_about_app.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_about_app).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_app_container, fragment_about_app, "fragment_about_app").addToBackStack("fragment_about_app").commit();

        }
    }

    public void DisplayFragmentContact_us() {
        fragment_count += 1;

        fragment_contact_us = Fragment_Contact_US.newInstance();


        if (fragment_contact_us.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_contact_us).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_app_container, fragment_contact_us, "fragment_contact_us").addToBackStack("fragment_contact_us").commit();

        }
    }
    public void DisplayFragmentWater() {
        fragment_count += 1;

        fragment_connecting_water = Fragment_Connecting_Water.newInstance().newInstance();


        if (fragment_connecting_water.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_connecting_water).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_app_container, fragment_connecting_water, "fragment_connecting_water").addToBackStack("fragment_connecting_water").commit();

        }
    }
    public void DisplayFragmentshipping_main() {
        fragment_count += 1;

        fragment_main_shipping_transportation = Fragment_Main_Shipping_Transportation.newInstance().newInstance();


        if (fragment_main_shipping_transportation.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_main_shipping_transportation).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_app_container, fragment_main_shipping_transportation, "fragment_main_shipping_transportation").addToBackStack("fragment_main_shipping_transportation").commit();

        }

    }
    public void DisplayFragmentEquipment() {
        fragment_count += 1;

        fragment_rental_of_equipment = Fragment_Rental_Of_Equipment.newInstance();


        if (fragment_rental_of_equipment.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_rental_of_equipment).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_app_container, fragment_rental_of_equipment, "fragment_rental_of_equipment").addToBackStack("fragment_rental_of_equipment").commit();

        }
    }
    public void DisplayFragmentshipping_First() {
        fragment_count += 1;

        fragment_first_shipping_transportation = Fragment_First_shipping_Transportation.newInstance();

        if (fragment_first_shipping_transportation.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_first_shipping_transportation).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_shipping_transportation, fragment_first_shipping_transportation, "fragment_first_shipping_transportation").addToBackStack("fragment_first_shipping_transportation").commit();
        }


    }

    public void DisplayFragmentshipping_second() {
        fragment_count += 1;

        fragment_seconed_shipping_transportation = Fragment_seconed_shipping_Transportation.newInstance();

        if (fragment_seconed_shipping_transportation.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_seconed_shipping_transportation).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_shipping_transportation, fragment_seconed_shipping_transportation, "fragment_seconed_shipping_transportation").addToBackStack("fragment_seconed_shipping_transportation").commit();
        }
        if (fragment_main_shipping_transportation != null) {
            fragment_main_shipping_transportation.update_bar(25);
        }
    }

    public void DisplayFragmentshipping_Third() {
        fragment_count += 1;

        fragment_third_shipping_transportation = Fragment_Third_shipping_Transportation.newInstance();

        if (fragment_third_shipping_transportation.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_third_shipping_transportation).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_shipping_transportation, fragment_third_shipping_transportation, "fragment_third_shipping_transportation").addToBackStack("fragment_third_shipping_transportation").commit();
        }
        if (fragment_main_shipping_transportation != null) {
            fragment_main_shipping_transportation.update_bar(50);
        }
    }

    public void DisplayFragmentshipping_Fourth() {
        fragment_count += 1;

        fragment_fourth_shipping_transpoortation = Fragment_Fourth_shipping_Transpoortation.newInstance();

        if (fragment_fourth_shipping_transpoortation.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_fourth_shipping_transpoortation).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_shipping_transportation, fragment_fourth_shipping_transpoortation, "fragment_fourth_shipping_transpoortation").addToBackStack("fragment_fourth_shipping_transpoortation").commit();
        }
        if (fragment_main_shipping_transportation != null) {
            fragment_main_shipping_transportation.update_bar(75);

        }
    }

    public void DisplayFragmentshipping_Fifth() {
        fragment_count += 1;

        fragment_fifth_shipping_transportation = Fragment_Fifth_shipping_Transportation.newInstance();

        if (fragment_fifth_shipping_transportation.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_fifth_shipping_transportation).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_shipping_transportation, fragment_fifth_shipping_transportation, "fragment_fifth_shipping_transportation").addToBackStack("fragment_fifth_shipping_transportation").commit();
        }
        if (fragment_main_shipping_transportation != null) {
            fragment_main_shipping_transportation.update_bar(100);


        }
    }
    public void DisplayFragmentUpgrade() {
        fragment_count += 1;

        fragment_upgrade_to_company = Fragment_Upgrade_To_Company.newInstance();


        if (fragment_upgrade_to_company.isAdded()) {
            fragmentManager.beginTransaction().show(fragment_upgrade_to_company).commit();
        } else {
            fragmentManager.beginTransaction().add(R.id.fragment_app_container, fragment_upgrade_to_company, "fragment_upgrade_to_company").addToBackStack("fragment_upgrade_to_company").commit();

        }
    }
    @Override
    public void onBackPressed() {
        Back();
    }

    public void Back() {
        if (fragment_count > 1) {
            if (fragment_main_shipping_transportation != null && fragment_main_shipping_transportation.isVisible()) {
                if (fragment_count > 3) {
                    fragment_count -= 1;
                    fragment_main_shipping_transportation.update_bar();
                    super.onBackPressed();
                } else {
                    fragment_count -= 2;
                    super.onBackPressed();
                    super.onBackPressed();

                }
            } else {
                fragment_count -= 1;
                super.onBackPressed();
            }
        } else {

            if (fragment_home != null && fragment_home.isVisible()) {
                if (fragment_main != null && fragment_main.isVisible()) {
                   /* if (userModel == null) {
                        NavigateToSignInActivity();
                    } else {*/
                    finish();
                    // }
                } else {
                    DisplayFragmentMain();
                }
            } else {
                DisplayFragmentHome();
            }
        }

    }

    public void NavigateToSignInActivity() {
        Intent intent = new Intent(this, Login_Activity.class);
        startActivity(intent);
        finish();

    }



}