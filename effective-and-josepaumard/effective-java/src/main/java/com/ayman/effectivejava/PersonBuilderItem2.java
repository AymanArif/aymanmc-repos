package com.ayman.effectivejava;

public class PersonBuilderItem2 {

    private final String title;// nonfinal for nonoptional

    private final String name; // final for mandatory

    private final String surname; // final for mandatory

    private final String prefix;// nonfinal for nonoptional

    private PersonBuilderItem2(Builder builder) {
        this.title = builder.title;
        this.name = builder.name;
        this.surname = builder.surname;
        this.prefix = builder.prefix;
    }

    public static Builder of(String name, String surname) {
        return new Builder(name, surname);
    }

    public static class Builder {

        // Required parameters: Immutable
        private final String name;
        private final String surname;

        // Optional parameters with default values
        private String title;

        private String prefix="Coder";


        private Builder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public static Builder of(String name, String surname) {
            return new Builder(name, surname);
        }

        // Setter
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        // Setter
        public Builder prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public PersonBuilderItem2 build() {
            return new PersonBuilderItem2(this);
        }
    }

    public static void main(String[] args){
        PersonBuilderItem2 person = Builder.of("Ayman", "Patel")
                                            .title("Mr")
                                            .prefix("Doctor")
                                            .build();
        System.out.println(person.title);
        System.out.println(person.prefix);

    }

}