
public class colorBlind {
    int question = 1;
    int correctAnswers = 0;
    int currentQuestion = 1;
    int[][] values = { { 3, 0, 5, 1, 12, 0 }, { 1, 1, 7, 0, 9, 0 }, { 6, 0, 5, 1, 9, 0 }, { 7, 0, 8, 0, 6, 1 },
            { 1, 0, 2, 0, 7, 1 }, { 6, 0, 9, 1, 5, 0 }, { 1, 0, 6, 0, 9, 1 }, { 12, 0, 7, 0, 4, 1 },
            { 0, 0, 6, 0, 1, 1 }, { 4, 1, 9, 0, 11, 0 }, { 5, 0, 3, 1, 10, 0 } };

    String[] resultStrings = { "Sinulla on värisokeus", "Sinulla on mahdollisesti värisokeus",
            "Sinulla ei ole värisokeutta" };
    String instructions = "Tämä on värinäkötesti. \n Valitse suppea tai laaja testi päävalikosta suorittaaksesi testin.\nSuppea testi on lyhyt testi yleisen värinäön testaamiseen.\n Laaja testi määrittää värisokeutesi tyypin.\nLisää testejä -osiossa on testejä spesifien värisokeustyyppien testaamiseen.\nTestiä suorittaessasi sinulle esitetään kuva ja kolme vastauspainiketta.\nPaina painiketta joka vastaa kuvassa esiintyvää numeroa.\nKun olet vastannut kaikkiin kysymyksiin, esittää testi sinulle tuloksesi.\nPalataksesi päävalikkoon, paina Alkuun. Sulkeaksesi sovelluksen paina Sulje.\nHUOM: Laaja testi ja lisää testejä ei toimi nykyisessä ohjelman versiossa.";

    public void nextQuestion() {
        currentQuestion = currentQuestion + 1;
    }

    public void addCorrectAnswers(int num) {
        correctAnswers = correctAnswers + num;
    }

}
