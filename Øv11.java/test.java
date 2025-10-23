public class test {
    public static void main(String[] args){
        Tomt tomt1 = new Tomt("Gloppen", 1445, 77, 631, "null", 1017.6, "Jens Olsen");
        Tomt tomt2 = new Tomt("Gloppen", 1445, 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        Tomt tomt3 = new Tomt("Gloppen", 1445, 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
        Tomt tomt4 = new Tomt("Gloppen", 1445, 74, 188, "null", 1457.2, "Karl Ove Bråten");
        Tomt tomt5 = new Tomt("Gloppen", 1445, 69, 47, "Høiberg", 1339.4, "Elsa Indregård");

        TomtRegister reg = new TomtRegister();

        reg.addTomt("Gloppen", 1445, 77, 631, "null", 1017.6, "Jens Olsen");
        reg.addTomt("Gloppen", 1445, 77, 131, "Syningom", 661.3, "Nicolay Madsen");
        reg.addTomt("Gloppen", 1445, 75, 19, "Fugletun", 650.6, "Evilyn Jensen");
        reg.addTomt("Gloppen", 1445, 74, 188, "null", 1457.2, "Karl Ove Bråten");
        reg.addTomt("Gloppen", 1445, 69, 47, "Høiberg", 1339.4, "Elsa Indregård");

        System.out.println(reg.getAll());
    }
}
