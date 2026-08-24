# Dockerfile Unused Stage Companion

Warning on a named multi-stage Dockerfile build stage (`FROM ... AS
name`) that's never referenced by a later `COPY --from=name` and isn't
the file's own final stage — an orphaned intermediate stage that's
real, wasted build time and a confusing read for the next person
touching the file, usually left behind after a refactor that moved
what it built into another stage.

## Why it exists

A leftover build stage is easy to miss on review — the Dockerfile
still builds fine, it just wastes time building something nothing
copies from. Nothing in the IDE flags it today.

## Why built this way

- **100% static text analysis** — a plain-text line scanner, not a
  Dockerfile-language parser, so it works whether the real Docker
  plugin is installed or not.

## v0.1 scope — stated honestly, not exhaustively

Can't see a stage referenced only via an explicit `docker build
--target=name` invocation outside the file — that will be flagged as
a false positive. Stage names are matched case-insensitively, same as
Docker itself.

## Usage

Open any Dockerfile with multiple `FROM ... AS name` stages. An
orphaned intermediate stage shows a warning.

## Enterprise / Team Licensing

Need enterprise features, custom rules, or team licensing? Contact us at
**gaphunterlabs@gmail.com**.

## Development

```
./gradlew test           # unit tests
./gradlew buildPlugin    # generates build/distributions/*.zip
./gradlew verifyPlugin   # checks compatibility against real IDEs
```

## License

Apache-2.0. See `LICENSE`.
