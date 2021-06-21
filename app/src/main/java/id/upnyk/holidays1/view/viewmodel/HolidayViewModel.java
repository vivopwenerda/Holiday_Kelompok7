package id.upnyk.holidays1.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import id.upnyk.holidays1.model.holiday.HolidayDiscoverResponse;
import id.upnyk.holidays1.model.holiday.HolidaysItem;
import id.upnyk.holidays1.service.ApiMain;

public class HolidayViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<HolidaysItem>> listDiscoverHoliday = new MutableLiveData<>();

    public void setHolidayDiscover(){
        if(this.apiMain == null){
            apiMain = new ApiMain();
        }
        apiMain.getApiHoliday().getHolidayDiscover().enqueue(new Callback<HolidayDiscoverResponse>() {
            @Override
            public void onResponse(Call<HolidayDiscoverResponse> call, Response<HolidayDiscoverResponse> response) {
                HolidayDiscoverResponse responseDiscover = response.body();
                if(responseDiscover != null && responseDiscover.getHolidays() !=null){
                    ArrayList<HolidaysItem> holidayDiscoverItems = responseDiscover.getHolidays();
                    listDiscoverHoliday.postValue(holidayDiscoverItems);
                }
            }

            @Override
            public void onFailure(Call<HolidayDiscoverResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<HolidaysItem>> getHolidayDiscover(){
        return listDiscoverHoliday;
    }
}
