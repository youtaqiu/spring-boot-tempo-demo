#!/bin/bash
set -e

echo "Building jar..."
mvn clean install

NID=$(docker network ls | grep "tempo-net" | awk '{print $1}')
if [ -n "$NID" ]; then
  echo "exist[tempo-net]network，NID=$NID"
else
  echo "Creating docker network..."
  docker network create tempo-net
  echo "Done create docker network..."
fi

echo "Running docker-compose up..."
docker-compose -f docker-compose.yml up -d
echo "Done docker-compose up..."

echo "Cleaning previous docker images..."
docker image prune -f
echo "Cleaned previous docker images..."
