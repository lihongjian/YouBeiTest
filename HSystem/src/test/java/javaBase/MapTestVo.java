package javaBase;

public class MapTestVo {

    String content = "";

    public MapTestVo(String content){
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj!=null && obj instanceof MapTestVo)
        return this.content.equals(((MapTestVo) obj).content);
        else return false;
    }

    @Override
    public int hashCode() {
        return 800;
    }
}
