package me.shinybless.Galactic;

import me.shinybless.Galactic.Commands.Comandos;
import me.shinybless.Galactic.Commands.Staff;
import me.shinybless.Galactic.Commands.Teams;
import org.bukkit.plugin.java.JavaPlugin;

import static me.shinybless.Galactic.Scoreboard.startScoreboard;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        new Scenarios(this);
        new Comandos(this);
        new Eventos(this);
        new Menu(this);
        new Staff(this);
        new Teams(this);
        new Towers(this);
        new Scoreboard(this);
        startScoreboard();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
