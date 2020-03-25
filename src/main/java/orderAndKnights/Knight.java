package orderAndKnights;

public class Knight {

    private String name;
    private int power;
    private Site site;
    private SwordColor swordColor;
    private Site[] sites = Site.values();
    private SwordColor[] swordColors = SwordColor.values();

    public Knight() {
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
                "'name'" + "'" +name+"'" +
                 "'power'" +"'" + power +"'" +
                "'site'" +"'"+ site + "'" +
                "'swordColor'" + "'"+swordColor+"'"
                ;
    }
}
