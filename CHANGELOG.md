<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Dockerfile Unused Stage Companion Changelog

## [Unreleased]

## [0.1.0]

### Added

- Warning on a named Dockerfile build stage never referenced by a
  later `COPY --from=` and not the file's final stage.
- 100% static text analysis, no network calls, no telemetry. Free.

[Unreleased]: https://github.com/GapHunterLabs/dockerfile-unused-stage-companion/compare/0.1.0...HEAD
[0.1.0]: https://github.com/GapHunterLabs/dockerfile-unused-stage-companion/commits/0.1.0
