# compiler and flags
CC := ${CC}
CFLAGS := ${CFLAGS}


# target executable
TARGET = ''

# source and object files
SRCS = math-lib.c advanced-calculator.c
OBJS = $(SRCS: .c = .o)

# default rule
all: $(TARGET)

# link object files to create executable file
$(TARGET) : $(OBJS)
	$(CC) $(CFLAGS) $(LDFLAGS) -o $(TARGET) $(OBJS)

# compile files, but not link
%.o : %.c
	$(CC) $(CFLAGS) -c $< -o $@


# install the files
install:
	install -d ${DESTDIR}${BINDIR}
	install -m 755 ${TARGET} ${DESTDIR}${BINDIR}


# clean rule to remove build artifacts
clean:
	rm -f $(OBJS) $(TARGET)


