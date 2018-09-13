package ar.com.eayzenberg.httpModel;

public class MutantsStats {
    private Integer count_mutant_dna;
    private Integer count_human_dna;
    private Double ratio;

    public MutantsStats() { }

    public MutantsStats(Integer count_mutant_dna, Integer count_human_dna) {
        this.count_mutant_dna = count_mutant_dna;
        this.count_human_dna = count_human_dna;
        if (count_human_dna != null &&
            count_mutant_dna != null &&
            count_human_dna != 0) {
            this.ratio = new Double(count_mutant_dna) /
                         new Double(count_human_dna);
        } else {
            ratio = 0.0;
        }
    }

    public Integer getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(Integer count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public Integer getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(Integer count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }
}
