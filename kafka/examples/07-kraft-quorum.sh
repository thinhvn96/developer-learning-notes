#!/usr/bin/env bash
# Usage: ./07-kraft-quorum.sh
# Shows the KRaft controller quorum and feature levels of a single combined node (lesson 0019).
source "$(dirname "$0")/kafka-common.sh"
echo "=== process.roles of this node"
ksh 'grep -E "^(process.roles|controller.quorum|node.id)" /opt/kafka/config/server.properties 2>/dev/null || env | grep -E "KAFKA_(PROCESS_ROLES|CONTROLLER_QUORUM|NODE_ID)"'
echo "=== kafka-metadata-quorum.sh describe --status"
kx kafka-metadata-quorum.sh $BS describe --status
echo "=== kafka-features.sh describe"
kx kafka-features.sh $BS describe
echo "=== the metadata log on disk"
ksh 'ls -d /tmp/kraft-combined-logs/__cluster_metadata-0'
