package com.growdever.exeception;

public class ExecaoDePaginaNaoEncontrada extends RuntimeException{

    public ExecaoDePaginaNaoEncontrada(String msg){
        super(msg);
    }
}
