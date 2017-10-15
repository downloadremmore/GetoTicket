package com.example.rim.Geto_Ticket.Managers.decoder;

import com.google.zxing.Result;

/**
 * Created by rim
 */

public interface DecodeImageCallback {

    void decodeSucceed(Result result);

    void decodeFail(int type, String reason);
}
