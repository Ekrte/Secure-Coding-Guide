import java.util.Arrays;

public class SetPublicArrayToPrivateArray {
    private String[] datas;
    public void setDatas(String[] datas) {
        this.datas = datas;
    }

    public static void main(String[] args) {
        SetPublicArrayToPrivateArray innerData = new SetPublicArrayToPrivateArray();
        innerData.setDatas(outerData);
    }
}