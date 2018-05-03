package test.poi.reader.example1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class SPImportAction extends HxlsAbstract{



    /**
     * @param args
     */
    public static void main(String[] args)
    {
        SPImportAction excel;
        try
        {

            long t1 = System.currentTimeMillis();
//            excel=new SPImportAction(SPImportAction.class.getClassLoader().getResource("").getPath() + "测试011.xls");
//            excel=new SPImportAction(SPImportAction.class.getClassLoader().getResource("").getPath() + "测试012.xls"); //44883  45000 32m
            excel=new SPImportAction(SPImportAction.class.getClassLoader().getResource("").getPath() + "测试013.xls"); //46m  60571


            excel.process();
            long t2 = System.currentTimeMillis();
            System.out.println("使用时间 : " + String.valueOf(t2 - t1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void optRows(int sheetIndex,int curRow, List<String> rowlist) throws SQLException
    {
                String row="";
                for (int i = 0 ;i< rowlist.size();i++){
                    row+=rowlist.get(i)+",";
                }


                for(int i = 0 ; i < rowlist.size() ; i ++){
                    System.out.println("页 : " + sheetIndex + "当前行 : " + curRow + "值 : " + rowlist.get(i));
                }

//
//                SPModel obj=new SPModel();
//                obj.setPRODUCTID(rowlist.get(1));
//                obj.setV_busiCode(rowlist.get(2));
//                obj.setV_busiName(rowlist.get(4));
//                obj.setV_busiDes(rowlist.get(5));
//                obj.setEFFDATE(rowlist.get(6));
//                obj.setEXPDATE(rowlist.get(7));
//                if(rowlist.get(3).equals("4"))
//                {
//                    obj.setFlag("1");
//                }
//                else
//                {
//                    obj.setFlag("0");
//                }
//
//                if(server.isSP(obj, ctx))
//                {
//                    int uflag=server.SPUpdate(obj, ctx);
//                    if(uflag>0)
//                    {
//                        successCount++;
//                        System.out.println("��"+rowlist.get(0)+"������޸ĳɹ�");
//                    }
//                    else
//                    {
//                        failCount++;
//                        System.out.println("��"+rowlist.get(0)+"������޸�ʧ��");
//                        errorList.add(rowlist.get(0));
//                    }
//                }
//                else
//                {
//                    int aflag=server.SPAdd(obj, ctx);
//                    if(aflag>0)
//                    {
//                        successCount++;
//                        System.out.println("��"+rowlist.get(0)+"����������ɹ�");
//                    }
//                    else
//                    {
//                        failCount++;
//                        System.out.println("��"+rowlist.get(0)+"���������ʧ��");
//                        errorList.add(rowlist.get(0));
//                    }
//                }
//                count++;
//                System.out.println(row.substring(0,row.length()-1));


    }
    public SPImportAction(String filename) throws IOException,FileNotFoundException, SQLException
    {
        super(filename);
    }
}