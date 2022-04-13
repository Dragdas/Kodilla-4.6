import com.kodilla.stream.beautifier.PoemBeautifier;


public class StreamMain {

    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String poem = "Na górze róże";
        String poem2 = "na dole bez";
        String poem3 = "biały wiersz";
        String poem4 = "nie rymuje się";

        poemBeautifier.beautify(poem, String::toUpperCase);
        poemBeautifier.beautify(poem2, (p -> "ABC "+p+" ABC"));
        poemBeautifier.beautify(poem3,(p -> p.replace('a','4') ));
        poemBeautifier.beautify(poem4, ( p -> p + ", joł!"));


    }

}
