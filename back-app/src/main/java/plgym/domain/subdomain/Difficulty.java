package plgym.domain.subdomain;

/**
 * Exercises difficulty enumerated class.
 * @author leodeorce
 * @author pedrovic7997
 */
public enum Difficulty
{
    FACIL {
        public String toString() {
            return "Fácil";
        }
    },
    MEDIO {
        public String toString() {
            return "Médio";
        }
    },
    DIFICIL {
        public String toString() {
            return "Difícil";
        }
    },
}