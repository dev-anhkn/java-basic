package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Joe Bambrick", "Northern Ireland", 616));
        players.add(new Player("Lionel Messi", "Argentina", 838));
        players.add(new Player("Cristiano Ronaldo", "Portugal", 900));
        players.add(new Player("Robert Lewandowski", "Poland", 634));
        players.add(new Player("Romário", "Brazil", 755));
        players.add(new Player("Jimmy Jones", "Northern Ireland", 648));
        players.add(new Player("Ferenc Puskás", "Hungary", 724));
        players.add(new Player("Gerd Müller", "Germany", 634));
        players.add(new Player("Josef Bican", "Austria", 722));
        players.add(new Player("Pelé", "Brazil", 762));

        // 1. Filter players whose names are longer than 10 characters
        List<Player> filteredPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getName().length() > 10) {
                filteredPlayers.add(player);
            }
        }

        // 2. Sort the list by number of goals in descending order
        filteredPlayers.sort((p1, p2) -> p2.getGoals() - p1.getGoals());

        // 3. Get the top 3 players
        if (filteredPlayers.size() > 3) {
            filteredPlayers = filteredPlayers.subList(0, 3);
        }
        System.out.println("filteredPlayers" + filteredPlayers);

        List<Player> filteredPlayersStream = players.stream()
                // Bước 1: Lọc tên dài hơn 10 ký tự
                .filter(player -> player.getName().length() > 10)

                // Bước 2: Sắp xếp theo số bàn thắng giảm dần
                .sorted((p1, p2) -> Integer.compare(p2.getGoals(), p1.getGoals()))

                // Bước 3: Lấy top 3 cầu thủ
                .limit(3)

                // Thu thập lại thành danh sách
                .toList();
        System.out.println("filteredPlayersStream" + filteredPlayersStream);

        // từ Player → String
        List<String> names = players.stream().map(Player::getName).toList();

        System.out.println("map" + names);

        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d")
        );

        // "làm phẳng" Stream<List<String>> → Stream<String>
        List<String> flatList = listOfLists.stream().flatMap(Collection::stream).toList();
        System.out.println("flatList" + flatList);
    }
}