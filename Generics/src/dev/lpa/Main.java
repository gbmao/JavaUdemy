package dev.lpa;

interface Player {
    String name();
}

record BaseballPlayer(String name, String position) implements Player {
}

record FootBallPlayer(String name, String position) implements Player {
}

record VolleyBallPlayer(String name, String position) implements Player {
}

public class Main {
    public static void main(String[] args) {

        var philly = new Affiliation("City", "Philadelphia, PA",
                "US");
        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResults(phillies1, 3, astros1, 5);

        SportTeam phillies = new SportTeam("Philadelphia Phillies");
        SportTeam astros = new SportTeam("Houston Astros");
        scoreResults(phillies, 3, astros, 5);

        Team<BaseballPlayer, Affiliation> phillies2 = new Team<>(philly,"Philadelphia Phillies");
        Team<BaseballPlayer, Affiliation> astros2 = new Team<>("Houston Astros");
        phillies2.listTeamMembers();
        scoreResults(phillies2, 3, astros2, 5);


        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();


        SportTeam afc1 = new SportTeam("Adelaine Crows");
        Team<FootBallPlayer, String> afc = new Team<>("Adelaine Crows", " Test");
        var tex = new FootBallPlayer("Tex Walker", "Center half forward");
        afc.addTeamMember(tex);
        var rory = new FootBallPlayer("Rory Laird", "Midfield");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team<VolleyBallPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyBallPlayer("N Roberts", "Setter"));
        adelaide.listTeamMembers();

        var canberra = new Team<VolleyBallPlayer, Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VolleyBallPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        scoreResults(canberra, 0, adelaide, 1);

//        Team<Integer>   melbourneVB = new Team<>("Melbourne Vipers");


    }

    public static void scoreResults(BaseballTeam team1, int t1_score,
                                    BaseballTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResults(SportTeam team1, int t1_score,
                                    SportTeam team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResults(Team team1, int t1_score,
                                    Team team2, int t2_score) {
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

}
