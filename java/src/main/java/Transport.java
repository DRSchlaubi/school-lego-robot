import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Transport {
    private static final int[][] ziele = new int[14][2];
    private final int[] fahrten;

    public Transport(int[] touren) {
        fahrten = Arrays.copyOf(touren, touren.length);
    }

    public Transport(int einzelfahrt) {
        this.fahrten = new int[]{einzelfahrt};
    }

    public int ermittleGesamtfahrzeit() {
        return Arrays.stream(fahrten).map(this::bekommeStreckenzeit).sum();
    }

    private int bekommeStreckenzeit(int fahrzielnummer) {
        fuelleZiele();
        for (var ziel : ziele) {
            if (fahrzielnummer == ziel[0]) {
                return ziel[1];
            }
        }
        System.out.println("kein Eintrag - Fehlerhafte Berechnung");
        return 0;
    }

    public String minutenInStundeMinute(int minute) {
        var duration = Duration.ofMinutes(minute);
        var output = new StringBuilder();

        if (duration.toHoursPart() > 0) {
            output.append(duration.toHoursPart())
                    .append(' ')
                    .append("Std.")
                    .append(' ');
        }
        output.append(duration.toMinutesPart());
        output.append(' ');
        output.append("Min.");

        return output.toString();
    }

    public void print() {
        print(true);
    }
    public void print(boolean pretty) {
        var heading1 = fahrten.length > 1 ? "Fahrziele" : "Fahrziel";
        var destinations = Arrays.stream(fahrten)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        var time = ermittleGesamtfahrzeit();
        var formattedTime = pretty ? minutenInStundeMinute(time) : "%s Minuten".formatted(time);
        System.out.printf("""
                        
                %s: %s
                Dauer: %s
                        
                %n""", heading1, destinations, formattedTime);
    }

    private static void fuelleZiele() {
        for (int i = 0; i < ziele.length; i++) {
            ziele[i] = new int[2];
        }
        ziele[0][0] = 1;
        ziele[0][1] = 63; // Garmisch-Partenkirchen
        ziele[1][0] = 2;
        ziele[1][1] = 59; // Rosenheim
        ziele[2][0] = 3;
        ziele[2][1] = 60; // Wasserburg
        ziele[3][0] = 4;
        ziele[3][1] = 72; // Mühldorf am Inn
        ziele[4][0] = 5;
        ziele[4][1] = 43; // Moosburg an der Isar
        ziele[5][0] = 6;
        ziele[5][1] = 54; // Ingolstadt
        ziele[6][0] = 7;
        ziele[6][1] = 42; // Aichach
        ziele[7][0] = 8;
        ziele[7][1] = 44; // Landsberg am Lech
        ziele[8][0] = 11;
        ziele[8][1] = 50; // Weilheim in Oberbayern
        ziele[9][0] = 22;
        ziele[9][1] = 56; // Bad Tölz
        ziele[10][0] = 551;
        ziele[10][1] = 42; // Erding
        ziele[11][0] = 552;
        ziele[11][1] = 32; // Freising
        ziele[12][0] = 771;
        ziele[12][1] = 20; // Dachau
        ziele[13][0] = 881;
        ziele[13][1] = 28; // Fürstenfeldbruck
    }
}
