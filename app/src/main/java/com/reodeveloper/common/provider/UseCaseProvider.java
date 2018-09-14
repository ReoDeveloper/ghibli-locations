package com.reodeveloper.common.provider;

import android.content.Context;

import com.reodeveloper.ghibli_locations.domain.usecase.GetLocations;

public class UseCaseProvider {
    public static GetLocations provideGetLocationsUseCase(Context context){
        return new GetLocations(RepositoryProvider.provideLocationRepository(context));
    }
}
