ALTER TABLE skill
DROP CONSTRAINT ck_skill_type;

ALTER TABLE skill
ADD CONSTRAINT ck_skill_type CHECK (skill_type IN ('HARD_SKILL', 'SOFT_SKILL'));