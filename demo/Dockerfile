# Orphaned stage -- nothing copies from it. Flagged.
FROM golang:1.21 AS old-builder
WORKDIR /src
RUN echo "leftover from before the build moved to node-builder"

# Referenced by the final stage below. Not flagged.
FROM node:20 AS node-builder
WORKDIR /app
RUN echo "builds the real app"

FROM alpine:3.19
COPY --from=node-builder /app/dist /app
CMD ["/app/server"]
