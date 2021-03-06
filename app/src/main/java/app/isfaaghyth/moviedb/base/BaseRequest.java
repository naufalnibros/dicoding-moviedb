package app.isfaaghyth.moviedb.base;

import android.content.Context;

import app.isfaaghyth.moviedb.network.Network;
import app.isfaaghyth.moviedb.network.Routes;
import app.isfaaghyth.moviedb.utils.ProgressLoader;

/**
 * Created by isfaaghyth on 7/24/18.
 * github: @isfaaghyth
 */

public class BaseRequest {

    private Routes request;

    protected void initialize() {
        request = Network.builder().create(Routes.class);
    }

    protected Routes getRequest() {
        return request;
    }

}
