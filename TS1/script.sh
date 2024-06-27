#!/bin/bash
start_directory="$1"
end_directory="$2"
find "$start_directory" -type f  |
while IFS= read -r file
do
	echo "$file"
	if [ -f "$file" ]; then
	echo "$file"
	fl="true"
	declare -i c=0
	name="${file##*/}"
	temp_name="$name"
	dir=$(dirname "$file")
	extention="${name##*.}"
	while [[ -f "$end_directory/$temp_name" || -f "$dir/$temp_name" ]]; do
	if [ "$name" != "$temp_name" ] || [ -f "$end_directory/$temp_name" ];
	then
		c="$c"+1
		fl="false"
		temp_name="${name%.*}($c).$extention"
	else
		fl="true"
		break
	fi
	done
	if [[ "$fl" == "false" ]];
	then
		mv "$file" "$dir""/$temp_name"
		cp "$dir""/$temp_name" "$end_directory"
		mv "$dir""/$temp_name" "$file"
	else
		cp "$dir""/$temp_name" "$end_directory"
	fi
fi
done
