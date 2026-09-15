package com.alternanceradar.enums;

/**
 * Defines the category of a skill within the Alternance Radar platform.
 * <p>
 *   Used to categorize skills linked to user profiles and job offers
 *   to refine compatibility matching calculations.
 *  </p>
 */
public enum SkillType {

    /**
     * Measurable technical or operational skill (e.g., Java, SQL, project management).
     */
    HARD_SKILL,

    /**
     * Interpersonal, behavioral, or emotional skill (e.g., communication, teamwork, adaptability).
     */
    SOFT_SKILL
}
