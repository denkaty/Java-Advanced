package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    private List<Player> removedPlayersByClassList;

    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
        this.removedPlayersByClassList = new ArrayList<>();
    }

    public List<Player> getRoster() {
        return roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String playerName) {
        return this.roster.removeIf(player -> player.getName().equals(playerName));
    }

    public void promotePlayer(String playerName) {
        for (Player player : this.roster) {
            if (player.getName().equals(playerName)) {
                if (!player.getRank().equals("Member")) {
                    player.setRank("Member");
                    break;
                }
            }
        }
    }

    public void demotePlayer(String playerName) {
        for (Player player : this.roster) {
            if (player.getName().equals(playerName)) {
                if (!player.getRank().equals("Trial")) {
                    player.setRank("Trial");
                    break;
                }
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removedPlayersByClassList = new ArrayList<>();

        for (int i = 0; i < this.roster.size(); i++) {
            Player player = this.roster.get(i);
            if (player.getClazz().equals(clazz)) {
                this.roster.remove(i);
                i--;
                removedPlayersByClassList.add(player);
            }
        }

        Player[] removedPlayersByClassArray = new Player[removedPlayersByClassList.size()];
        for (int i = 0; i < removedPlayersByClassList.size(); i++) {
            Player player = removedPlayersByClassList.get(i);
            removedPlayersByClassArray[i] = player;
        }
        return removedPlayersByClassArray;


    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Players in the guild: %s:",this.name)).append(System.lineSeparator());
        for (Player player : this.roster) {
            stringBuilder.append(player.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();

    }
}
