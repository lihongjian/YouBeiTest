/**
 * Created by hongjian on 2015/10/25.
 */

/**
 * && �߼���  ����true false
 *
 * || �߼��� �������߶���falseʱ,�������е�һ����Ϊfalse��ֵ�������һ��ֵ
 *
 * ! �߼���
 *
 * �߼�������
 *
 * 0 null NaN "" undefined ����ʾfalse
 *
 * Ҳ����˵�������ж�����Ϊtrue����,���߷���(||)
 */

function getLogicalOperatorTest(){
    var s1 = "this is s1";
    var s2 = "1";

    var n1 = 1;

    var b1 = false;
    var b2 = true;


  /*  alert(b1||s1); // ���� "this is s1"
    alert(b2||s1); // ���� ture

    alert(b1||s2); // ���� 1
    alert(b2||s2); // ���� ture

    alert(b1||n1); // ���� 1
    alert(b2||n1); // ���� ture

    alert(s2&&b2);  //���� true
    alert(!s2);     //���� false

   */
}

function T(e){
    e = e||{};
    alert(e.name);
}
