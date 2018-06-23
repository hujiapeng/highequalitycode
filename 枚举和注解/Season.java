package hqcode.枚举和注解;

public enum Season {

    Spring, Summer, Autum, Winter;

    public static Season getComfortableSeason() {
        return Spring;
    }

    public static boolean contains(String name) {
        Season[] seasons = values();
        for (Season season : seasons) {
            if (season.name().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
