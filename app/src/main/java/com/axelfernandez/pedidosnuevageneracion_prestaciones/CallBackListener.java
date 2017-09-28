package com.axelfernandez.pedidosnuevageneracion_prestaciones;

/**
 * Created by axelfernandez on 2/9/17.
 */

public interface CallBackListener
{
    void onCallBack(String name, String precio, int cantidad);// pass any parameter in your onCallBack which you want to return
}
