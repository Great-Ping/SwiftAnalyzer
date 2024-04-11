package lexicon.tokens.keywords

@JvmInline
value class KeywordNames (
    val flag: Int
) {
    companion object{
        val VAR = KeywordNames(0b1)
        val VAL = KeywordNames(0b01)
        val IF = KeywordNames(0b001)
    }

    operator fun contains(names: KeywordNames): Boolean {
        return hasFlag(names);
    }

    infix fun and(names: KeywordNames) : KeywordNames {
        return KeywordNames(this.flag and names.flag)
    }

    infix fun or(names: KeywordNames) : KeywordNames{
        return KeywordNames(this.flag or names.flag)
    }

    fun hasFlag(names: KeywordNames): Boolean {
        return (this and names).flag != 0;
    }
}