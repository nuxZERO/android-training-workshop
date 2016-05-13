package me.cafecode.android.workshop.endpoints;

import me.cafecode.android.workshop.models.DetailsResponse;
import me.cafecode.android.workshop.models.NearbySearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Natthawut Hemathulin on 4/16/16 AD.
 * Email: natthawut1991@gmail.com
 */
public interface GooglePlaceService {

    @GET("nearbysearch/json")
    Call<NearbySearchResponse> nearbySearch(@Query("key") String key, @Query("type") String type, @Query("location") String locationStr, @Query("radius") String radius, @Query("rankby") String rankBy);

    @GET("details/json")
    Call<DetailsResponse> details(@Query("key") String key, @Query("placeid") String placeId);

}
