package br.com.desafio.criptografia;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class CriptografiaJulioCesar {
    private Map<String, String> mapAlfabeto = new HashMap<String, String>();

    CriptografiaJulioCesar(){
        inicializaAlfabeto();
    }

    private void inicializaAlfabeto() {
        mapAlfabeto.put("a","z");
        mapAlfabeto.put("b","a");
        mapAlfabeto.put("c","b");
        mapAlfabeto.put("d","c");
        mapAlfabeto.put("e","d");
        mapAlfabeto.put("f","e");
        mapAlfabeto.put("g","f");
        mapAlfabeto.put("h","g");
        mapAlfabeto.put("i","h");
        mapAlfabeto.put("j","i");
        mapAlfabeto.put("k","j");
        mapAlfabeto.put("l","k");
        mapAlfabeto.put("m","l");
        mapAlfabeto.put("n","m");
        mapAlfabeto.put("o","n");
        mapAlfabeto.put("p","o");
        mapAlfabeto.put("q","p");
        mapAlfabeto.put("r","q");
        mapAlfabeto.put("s","r");
        mapAlfabeto.put("t","s");
        mapAlfabeto.put("u","t");
        mapAlfabeto.put("v","u");
        mapAlfabeto.put("w","v");
        mapAlfabeto.put("x","w");
        mapAlfabeto.put("y","x");
        mapAlfabeto.put("z","y");
    }

    public String criptografar(String texto, int numeroCasas) {
        String descriptografado = "";
        texto=texto.toLowerCase();
        String[] percorredor = texto.split("");

        for(int i=0;i<percorredor.length;i++){
            String elemento = percorredor[i];
            if(!mapAlfabeto.containsKey(elemento)){
                descriptografado+=elemento;
            }else{
                String proxElemento =  elemento;
                for(int k=0;k<numeroCasas;k++){
                    proxElemento = mapAlfabeto.get(proxElemento);
                }
                descriptografado+=proxElemento;
            }
        }
        return descriptografado;
    }

    public String resumoCriptografo(String texto){
        String resumo = "";
        try {
            MessageDigest algorithm = MessageDigest.getInstance("sha1");
            byte messageDigest[] = algorithm.digest(texto.getBytes());
            resumo = stringHexa(messageDigest);
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }
        return resumo;
    }

    private static String stringHexa(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) s.append('0');
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }
}
