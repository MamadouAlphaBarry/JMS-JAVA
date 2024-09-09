package it.cws.meta;

public  class Main {
    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        //second.setNextSong(first);

        System.out.println(first.isInRepeatingPlaylist());
    }
}

 class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isInRepeatingPlaylist() {
        if (this.name.contains())
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }


}