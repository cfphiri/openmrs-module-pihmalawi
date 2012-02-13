#!/bin/bash
date >/home/emradmin/rebuild_person_name_codes.log
/home/emradmin/bart2/script/console <<EOF
PersonNameCode.rebuild_person_name_codes
exit
EOF
date >>/home/emradmin/rebuild_person_name_codes.log
echo "DONE" >>/home/emradmin/rebuild_person_name_codes.log

MAIL=apzu-emr@apzu.pih.org
PATH=$PATH:/bin:/usr/bin:/home/emradmin/pihmalawi/scripts

TODAY=`date +%Y%m%d`

echo "" | mailx -s "emr: Upper Neno rebuild_person_name_codes $TODAY" "$MAIL"
