package prog42579;

import java.util.*;

public class MyMain {
    public static void main(String[] args) {
        String[] jenres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        Solution mSol = new Solution();

        System.out.println(mSol.solution(jenres, plays));
    }
}

// 1. 장르 순위
// 2. 재생 순위(장르내)
// 3. id 순위

// 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
// 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
// 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answers = new ArrayList<>();
        HashMap<String, Jenre> jSet = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (jSet.containsKey(genres[i])) {
                jSet.get(genres[i]).play += plays[i];
            } else {
                jSet.put(genres[i], new Jenre(genres[i], plays[i]));
                jSet.get(genres[i]).songs = new TreeSet<>();
            }
            jSet.get(genres[i]).songs.add(new Song(i, plays[i]));
        }

        jSet.values().stream().sorted().forEach(
                (j) -> {
                    System.out.println(j.name);
                    int releaseCount = 0;

                    Iterator<Song> songIter = j.songs.iterator();
                    while (songIter.hasNext()) {
                        Song s = (Song) songIter.next();
                        System.out.println(s.idx + ", ");
                        answers.add(s.idx);
                        if (++releaseCount > 1) {
                            break;
                        }
                    }
                });

        System.out.println(jSet);

        int[] answer = new int[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        return answer;
    }
}

class Jenre implements Comparable<Jenre> {
    String name;
    int play;
    TreeSet<Song> songs;

    public Jenre(String j, int play) {
        this.name = j;
        this.play = play;
    }

    @Override
    public String toString() {
        return name + ":" + play + ",songs: " + songs + "\n";
    }

    @Override
    public int compareTo(Jenre o) {
        return play > o.play ? -1 : 1;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

class Song implements Comparable<Song> {
    int idx;
    int play;

    public Song(int idx, int play) {
        this.idx = idx;
        this.play = play;
    }

    @Override
    public String toString() {
        return "idx: " + idx + ", play" + play;
    }

    @Override
    public int compareTo(Song o) {
        return play > o.play ? -1 : 1;
    }

}