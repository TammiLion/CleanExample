package com.example.troep.cleanexample.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Intercepts to add the API key.
 * Copied from https://futurestud.io/tutorials/retrofit-2-how-to-add-query-parameters-to-every-request
 * How to use: add 'okHttpClientBuilder.addInterceptor(new AuthenticationInterceptor());' to ApiModule.
 *
 * @author t.roep
 * @version 1
 * @since 06-12-2016
 */
public class AuthenticationInterceptor implements okhttp3.Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("PARAM_NAME", "API_KEY")
                .build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder()
                .url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}