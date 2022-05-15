/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1;

/**
 *
 * @author TechNorider
 */
public class addevidence {
    private String caseid,EvidenceType,Evidence,SuspectName,Points,Note;

    /**
     * @return the caseid
     */
    public String getCaseid() {
        return caseid;
    }

    /**
     * @param caseid the caseid to set
     */
    public void setCaseid(String caseid) {
        this.caseid = caseid;
    }

    /**
     * @return the Evidence
     */
    public String getEvidence() {
        return Evidence;
    }

    /**
     * @param Evidence the Evidence to set
     */
    public void setEvidence(String Evidence) {
        this.Evidence = Evidence;
    }

    /**
     * @return the SuspectName
     */
    public String getSuspectName() {
        return SuspectName;
    }

    /**
     * @param SuspectName the SuspectName to set
     */
    public void setSuspectName(String SuspectName) {
        this.SuspectName = SuspectName;
    }

    /**
     * @return the EvidenceType
     */
    public String getEvidenceType() {
        return EvidenceType;
    }

    /**
     * @param EvidenceType the EvidenceType to set
     */
    public void setEvidenceType(String EvidenceType) {
        this.EvidenceType = EvidenceType;
    }

    /**
     * @return the Points
     */
    public String getPoints() {
        return Points;
    }

    /**
     * @param Points the Points to set
     */
    public void setPoints(String Points) {
        this.Points = Points;
    }

    /**
     * @return the Note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param Note the Note to set
     */
    public void setNote(String Note) {
        this.Note = Note;
    }
}
