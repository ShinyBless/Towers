package me.shinybless.Galactic;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class Scoreboard {
    private static Main plugin;

    public Scoreboard(Main plugin) {
        this.plugin = plugin;
    }

    public static ScoreboardManager manager = Bukkit.getScoreboardManager();
    public static org.bukkit.scoreboard.Scoreboard board = manager.getNewScoreboard();
    public static Team teamblue = board.registerNewTeam("Azul");
    public static Team teamred = board.registerNewTeam("Rojo");

    public static void startScoreboard() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    p.setScoreboard(board);
                    Scoreboard.board.resetScores(p);
                }
            }
        }.runTaskTimer(plugin, 0L, 60L);
    }

    public static void setScoreboard(Player p) {
        teamblue.setPrefix("§9");
        teamblue.setCanSeeFriendlyInvisibles(true);
        teamred.setAllowFriendlyFire(false);
        teamred.setPrefix("§c");
        teamred.setCanSeeFriendlyInvisibles(true);
        teamred.setAllowFriendlyFire(false);
        Towers.score.putIfAbsent("BlueTeam", 0);
        Towers.score.putIfAbsent("RedTeam", 0);

        Objective galactic = board.registerNewObjective("§7●§9Galactic§7●", "dummy");
        galactic.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score1 = galactic.getScore("§6Puntos");
        score1.setScore(4);

        Score score2 = galactic.getScore("§9Azul §7➛ " + Towers.score.get("BlueTeam"));
        score2.setScore(3);

        Score score3 = galactic.getScore("§cRojo §7➛ " + Towers.score.get("RedTeam"));
        score3.setScore(2);

        Score score4 = galactic.getScore("");
        score4.setScore(0);
        p.setScoreboard(board);
    }

    public static void setTeamBlue(Player p){
        teamblue.addPlayer(p);
    }

    public static void setTeamRed(Player p){
        teamred.addPlayer(p);
    }

    public static void unsetTeamBlue(Player p){
        teamblue.removePlayer(p);
    }

    public static void unsetTeamRed(Player p){
        teamred.removePlayer(p);
    }
}
