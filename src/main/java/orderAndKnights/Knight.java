package orderAndKnights;

public class Knight {
    private int id;
    private String name;
    private SwordColor swordColor;
    private int power;
    private Site site;
    private Site[] sites = Site.values();
    private SwordColor[] swordColors = SwordColor.values();

    public Knight() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(int siteOfForce) {
        this.site = sites[siteOfForce];
    }

    public SwordColor getSwordColor() {
        return swordColor;
    }

    public void setSwordColor(int swordColor) {
        this.swordColor = swordColors[swordColor];
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", swordColor=" + swordColor +
                        ", power=" + power +
                        ", site=" + site + "\n";

    }

    public String sqlFormat() {
        return
                "('" + name + "'," +
                        "'" + swordColor + "'," +
                        "'" + power + "'," +
                        "'" + site + "'," + "\n"
                ;
    }

    public String simlpeFormat() {
        return id + " " + name + " " + swordColor + " " + power + " " + site + "\n";
    }


}
