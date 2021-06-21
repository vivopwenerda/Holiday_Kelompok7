package id.upnyk.holidays1.service;

import retrofit2.Call;
import retrofit2.http.GET;
import id.upnyk.holidays1.model.holiday.HolidayDiscoverResponse;

public interface HolidayRepository {
    @GET("v1/holidays?pretty&key=eedad42f-d88d-4d78-a720-ba2ea1ac1ea4&country=ID&year=2020")
    Call<HolidayDiscoverResponse> getHolidayDiscover();


}
