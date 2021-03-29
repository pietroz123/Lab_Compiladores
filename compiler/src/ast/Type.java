package ast;

abstract public class Type {

    public Type( String name ) {
        this.name = name;
    }

    public static Type booleanType = new TypeBoolean();
    public static Type intType = new TypeInt();
    public static Type stringType = new TypeString();
    public static Type undefinedType = new TypeUndefined();
    public static Type nullType = new TypeNull();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    abstract public String getCname();

    private String name;

    /**
     * Verifica se dois tipos são compatíveis
     * @param other
     * @return
     */
    public boolean isCompatible(Type other) {

        if ( this == Type.booleanType ) {
            return other == Type.booleanType;
        }
        else if ( this == Type.intType ) {
            return other == Type.intType;
        }
        else if ( this == Type.stringType ) {
            return other == Type.stringType;
        }
        else if ( this == Type.nullType ) {
            return false;
        }
        else if ( this instanceof TypeCianetoClass ) {
            return this == other || ((TypeCianetoClass) this).isSubclassOf(other);
        }
        else {
            return false;
        }

    }

}
